// Copyright (C) CSIRO Australia Telescope National Facility
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.
//

package atnf.atoms.mon.archivepolicy;

import atnf.atoms.time.*;
import atnf.atoms.mon.*;

/**
 * Periodic archiver. Argument must be the archive interval in integer seconds.
 * 
 * @author Le Coung Nguyen
 */
public class ArchivePolicyTimer extends ArchivePolicy
{
    RelTime itsPeriod = null;

    AbsTime itsLastSaved = AbsTime.factory();

    public ArchivePolicyTimer(String args)
    {
        itsPeriod = RelTime.factory(1000000l*Long.parseLong(args));
    }

    public ArchivePolicyTimer(RelTime period)
    {
        itsPeriod = RelTime.factory(period);
    }

    public ArchivePolicyTimer(int period)
    {
        itsPeriod = RelTime.factory(period);
    }

    public boolean checkArchiveThis(PointData data)
    {
        if (data.getTimestamp().isAfter(itsLastSaved.add(itsPeriod))) {
            itsSaveNow = true;
            itsLastSaved = data.getTimestamp();
        } else {
            itsSaveNow = false;
        }
        return itsSaveNow;
    }
}