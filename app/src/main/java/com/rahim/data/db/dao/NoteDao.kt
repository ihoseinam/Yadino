package com.rahim.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.rahim.yadino.routine.modle.Rotin.Routine
import com.rahim.yadino.routine.modle.note.NoteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteModel: com.rahim.yadino.routine.modle.note.NoteModel)

    @Query("SELECT * FROM tbl_note ORDER BY timeInMileSecond ASC")
    fun getNotes(): Flow<List<com.rahim.yadino.routine.modle.note.NoteModel>>

    @Update
    suspend fun update(noteModel: com.rahim.yadino.routine.modle.note.NoteModel)
    @Delete
    suspend fun delete(noteModel: com.rahim.yadino.routine.modle.note.NoteModel)
    @Query("SELECT * FROM tbl_note WHERE name LIKE '%'||:searchName||'%' ORDER BY timeInMileSecond ASC")
    fun searchRoutine(
        searchName:String
    ): Flow<List<com.rahim.yadino.routine.modle.note.NoteModel>>
    @Query("SELECT * FROM tbl_note WHERE isSample=1")
    suspend fun getSampleNote():List<com.rahim.yadino.routine.modle.note.NoteModel>

    @Query("DELETE FROM tbl_note WHERE isSample=1")
    suspend fun removeSampleNote()
}