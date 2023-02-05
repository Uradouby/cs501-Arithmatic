package com.example.arithmatic

import androidx.lifecycle.ViewModel

class ArithViewModel: ViewModel() {
    private var op1:String=""
    private var op2:String=""
    private var op:Int=0

    fun setop(v:Int)
    {
        op=v
    }

    fun setop1(v:String)
    {
        op1=v;
    }

    fun setop2(v:String)
    {
        op2=v;
    }

    fun getop():Int
    {
        return op
    }

    fun getop1():String
    {
        return op1
    }

    fun getop2():String
    {
        return op2
    }
    fun checkStatus():Int
    {
        if (op==0) return -1
        if (op1=="" || op2=="") return -2
        if (op==4 && op2.toDouble()==0.0) return -3
        return 0;
    }

    fun getAnswer():Double
    {
        var o1:Double=op1.toDouble()
        var o2:Double=op2.toDouble()
        var ans:Double=0.0
        if (op==1) ans = o1+o2
        if (op==2) ans = o1-o2
        if (op==3) ans = o1*o2
        if (op==4) ans = o1/o2
        if (op==5) ans = o1%o2
        return ans
    }
}