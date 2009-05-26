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

public final class DataValueBooleanPrxHelper extends Ice.ObjectPrxHelperBase implements DataValueBooleanPrx
{
    public static DataValueBooleanPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        DataValueBooleanPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (DataValueBooleanPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::atnf::atoms::mon::comms::DataValueBoolean"))
                {
                    DataValueBooleanPrxHelper __h = new DataValueBooleanPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static DataValueBooleanPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        DataValueBooleanPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (DataValueBooleanPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::atnf::atoms::mon::comms::DataValueBoolean", __ctx))
                {
                    DataValueBooleanPrxHelper __h = new DataValueBooleanPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static DataValueBooleanPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        DataValueBooleanPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::atnf::atoms::mon::comms::DataValueBoolean"))
                {
                    DataValueBooleanPrxHelper __h = new DataValueBooleanPrxHelper();
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

    public static DataValueBooleanPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        DataValueBooleanPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::atnf::atoms::mon::comms::DataValueBoolean", __ctx))
                {
                    DataValueBooleanPrxHelper __h = new DataValueBooleanPrxHelper();
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

    public static DataValueBooleanPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        DataValueBooleanPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (DataValueBooleanPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                DataValueBooleanPrxHelper __h = new DataValueBooleanPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static DataValueBooleanPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        DataValueBooleanPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            DataValueBooleanPrxHelper __h = new DataValueBooleanPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _DataValueBooleanDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _DataValueBooleanDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, DataValueBooleanPrx v)
    {
        __os.writeProxy(v);
    }

    public static DataValueBooleanPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            DataValueBooleanPrxHelper result = new DataValueBooleanPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
