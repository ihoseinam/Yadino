package com.rahim.yadino.dateTime.model


//@Entity(tableName = "tbl_timeDate", primaryKeys = ["dayNumber","yerNumber","monthNumber"])
data class TimeDate(
    val dayNumber: Int,
    val haveTask: Boolean,
    var isToday: Boolean = false,
    val nameDay: String,
    val yerNumber: Int,
    val monthNumber: Int,
    var isChecked: Boolean,
    var monthName: String? = null,
    var versionNumber: Long? = null,
)