// !MARK_DYNAMIC_CALLS

// MODULE[js]: m1
// FILE: k.kt

fun test(d: dynamic) {
    d.<!DEBUG_INFO_DYNAMIC!>onAnyVal<!>
    d.<!DEBUG_INFO_DYNAMIC!>onAnyVal<!> = 1

    d?.<!DEBUG_INFO_DYNAMIC!>onAnyVal<!>
    d?.<!DEBUG_INFO_DYNAMIC!>onAnyVal<!> = 1

    d!!.<!DEBUG_INFO_DYNAMIC!>onAnyVal<!>
    d!!.<!DEBUG_INFO_DYNAMIC!>onAnyVal<!> = 1

    d.<!DEBUG_INFO_DYNAMIC!>onNullableAnyVal<!> = 1

    d.<!DEBUG_INFO_DYNAMIC!>onStringVal<!> = 1

    d.<!DEBUG_INFO_DYNAMIC!>onDynamicVal<!> = 1

    d?.<!DEBUG_INFO_DYNAMIC!>onDynamicVal<!> = 1

    (d: String).onStringVal
    (d: Any).onAnyVal
    (d: Any?).onNullableAnyVal
    (d: Any).onDynamicVal

    <!VAL_REASSIGNMENT!>(d: String).onStringVal<!> = 1
    <!VAL_REASSIGNMENT!>(d: Any).onAnyVal<!> = 1
    <!VAL_REASSIGNMENT!>(d: Any?).onNullableAnyVal<!> = 1
    <!VAL_REASSIGNMENT!>(d: Any).onDynamicVal<!> = 1
}

val Any.onAnyVal: Int get() = 1
val Any?.onNullableAnyVal: Int get() = 1
val String.onStringVal: Int get() = 1
val dynamic.onDynamicVal: Int get() = 1

class C {
    fun test(d: dynamic) {
        d.<!DEBUG_INFO_DYNAMIC!>memberVal<!>
        d.<!DEBUG_INFO_DYNAMIC!>memberExtensionVal<!>
    }

    val memberVal = 1
    val Any.memberExtensionVal: Int
        get() = 1
}