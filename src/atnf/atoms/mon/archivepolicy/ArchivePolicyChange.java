// Copyright (C) CSIRO Australia Telescope National Facility
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.
//

package atnf.atoms.mon.archivepolicy;

import java.lang.reflect.*;
import atnf.atoms.mon.*;
import atnf.atoms.mon.util.MonitorUtils;

/**
 * Archives data when the value changes.
 * 
 * <P>
 * The default value is to archive when the value changes at all, however an optional
 * argument can be used to specify a delta threshold (either absolute or as a percentage)
 * and archiving will only take place once the data value has changed by more than the
 * threshold since the data was last archived.
 * 
 * <P>
 * Examples:
 * <bl>
 * <li><b>Change-</b> This will archive every change of value.
 * <li><b>Change-"20"</b> Archive when the value changes by more then 20 (absolute).
 * <li><b>Change-"15%"</b> Archive when the value varies from the last archived value by more than 15% (relative).
 * </bl>
 * 
 * @author: Le Cuong Nguyen, David Brodrick
 */
public class ArchivePolicyChange extends ArchivePolicy
{
    /** The last data which was archived. */
    Object itsLastSaveData = null;

    /** Whether we are running in percentage mode. */
    boolean itsPercentage = false;

    /** Whether we are running in absolute delta mode. */
    boolean itsDelta = false;

    /** The absolute or relative change threshold. */
    float itsChangeThreshold;

    protected static String itsArgs[] = new String[] { "Data Changed", "CHANGE" };

    public ArchivePolicyChange(String args)
    {
        String[] tokens = MonitorUtils.tokToStringArray(args);
        if (tokens.length > 0) {
            if (tokens[0].indexOf("%") != -1) {
                tokens[0] = tokens[0].replace("%", "");
                itsPercentage = true;
            } else {
                itsDelta = true;
            }
            itsChangeThreshold = Float.parseFloat(tokens[0]);
        }
    }

    public boolean checkArchiveThis(PointData data)
    {
        Object newData = data.getData();
        if (newData == null && itsLastSaveData == null) {
            itsSaveNow = false;
            return itsSaveNow;
        }
        if (itsLastSaveData == null) {
            itsLastSaveData = newData;
            itsSaveNow = true;
            return itsSaveNow;
        } else if (newData == null) {
            itsLastSaveData = null;
            itsSaveNow = true;
            return itsSaveNow;
        }

        if (newData instanceof Number && itsLastSaveData instanceof Number) {
            float delta = Math.abs(((Number) (newData)).floatValue() - ((Number) (itsLastSaveData)).floatValue());
            if (itsDelta) {
                if (delta >= itsChangeThreshold) {
                    itsLastSaveData = newData;
                    itsSaveNow = true;
                } else {
                    itsSaveNow = false;
                }
            } else if (itsPercentage) {
                float percent = delta / Math.abs(((Number) (itsLastSaveData)).floatValue());
                if (percent >= itsChangeThreshold) {
                    itsLastSaveData = newData;
                    itsSaveNow = true;
                } else {
                    itsSaveNow = false;
                }
            } else {
                if (delta != 0.0f) {
                    itsLastSaveData = newData;
                    itsSaveNow = true;
                } else {
                    itsSaveNow = false;
                }
            }
        } else {
            try {
                Method equalsMethod = newData.getClass().getMethod("equals", new Class[] { Object.class });
                Object res = equalsMethod.invoke(newData, new Object[] { itsLastSaveData });
                itsSaveNow = !((Boolean) res).booleanValue();
                itsLastSaveData = newData;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return itsSaveNow;
    }

    public static String[] getArgs()
    {
        return itsArgs;
    }
}