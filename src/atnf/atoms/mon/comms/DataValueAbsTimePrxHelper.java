// **********************************************************************
//
// Copyright (c) 2003-2008 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.3.0

package atnf.atoms.mon.comms;

public final class DataValueAbsTimePrxHelper extends Ice.ObjectPrxHelperBase implements DataValueAbsTimePrx
{
    public static DataValueAbsTimePrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        DataValueAbsTimePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (DataValueAbsTimePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::atnf::atoms::mon::comms::DataValueAbsTime"))
                {
                    DataValueAbsTimePrxHelper __h = new DataValueAbsTimePrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static DataValueAbsTimePrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        DataValueAbsTimePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (DataValueAbsTimePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::atnf::atoms::mon::comms::DataValueAbsTime", __ctx))
                {
                    DataValueAbsTimePrxHelper __h = new DataValueAbsTimePrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static DataValueAbsTimePrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        DataValueAbsTimePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::atnf::atoms::mon::comms::DataValueAbsTime"))
                {
                    DataValueAbsTimePrxHelper __h = new DataValueAbsTimePrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static DataValueAbsTimePrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        DataValueAbsTimePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::atnf::atoms::mon::comms::DataValueAbsTime", __ctx))
                {
                    DataValueAbsTimePrxHelper __h = new DataValueAbsTimePrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static DataValueAbsTimePrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        DataValueAbsTimePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (DataValueAbsTimePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                DataValueAbsTimePrxHelper __h = new DataValueAbsTimePrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static DataValueAbsTimePrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        DataValueAbsTimePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            DataValueAbsTimePrxHelper __h = new DataValueAbsTimePrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _DataValueAbsTimeDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _DataValueAbsTimeDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, DataValueAbsTimePrx v)
    {
        __os.writeProxy(v);
    }

    public static DataValueAbsTimePrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            DataValueAbsTimePrxHelper result = new DataValueAbsTimePrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
