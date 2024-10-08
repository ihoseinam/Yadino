package com.rahim.yadino.base.enums

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
public enum class StateNote(val state: Int) : Parcelable {
  LOWE(0),
  MEDUOME(1),
  HEIGHT(2),
}
