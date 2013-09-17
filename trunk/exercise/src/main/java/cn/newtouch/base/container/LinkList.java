//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: LoToS
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package cn.newtouch.base.container;

public class LinkList<T>
{
    private int         length = 0;

    private LickListObj first;

    private LickListObj end;

    public LinkList()
    {

    }

    void add(LickListObj llo)
    {
        if (length <= 0)
        {
            first = llo;
            end = llo;
            llo.setLeft(llo);
            llo.setRight(llo);
        }
        else
        {
            end.setRight(llo);
            llo.setLeft(end);
            llo.setRight(first);
            first.setLeft(llo);
            end = llo;
        }
        length++;
    }

    void delete(LickListObj llo)
    {
        if (length <= 0)
        {
            return;
        }
        else
            if (length == 1)
            {
                first = end = null;
            }
            else
            {
                llo.getLeft().setRight(llo.getRight());
                llo.getRight().setLeft(llo.getLeft());

                if (llo == first)
                {
                    first = llo.getRight();
                }
                else
                    if (llo == end)
                    {
                        end = llo.getLeft();
                    }
            }
        length--;
    }

    public LickListObj getEnd()
    {
        return end;
    }

    public void setEnd(LickListObj end)
    {
        this.end = end;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public LickListObj getFirst()
    {
        return first;
    }

    public void setFirst(LickListObj first)
    {
        this.first = first;
    }

}
