package com.example.examen3_canelas.ListFragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.examen3_canelas.DB.Book
import java.io.Serializable
import java.lang.IllegalArgumentException

data class UpdateFragmentArgs(
    val currentBook: Book
) : NavArgs {
    @Suppress("CAST_NEVER_SUCCEEDS")
    fun toBundle(): Bundle {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Book::class.java)) {
            result.putParcelable("currentBook", this.currentBook as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Book::class.java)) {
            result.putSerializable("currentBook", this.currentBook as Serializable)
        } else {
            throw UnsupportedOperationException(Book::class.java.name +
                    " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
    }

    companion object {
        @JvmStatic
        fun fromBundle(bundle: Bundle): UpdateFragmentArgs {
            bundle.setClassLoader(UpdateFragmentArgs::class.java.classLoader)
            val __currentBook : Book?
            if (bundle.containsKey("currentBook")) {
                if (Parcelable::class.java.isAssignableFrom(Book::class.java) ||
                    Serializable::class.java.isAssignableFrom(Book::class.java)) {
                    __currentBook = bundle.get("currentBook") as Book?
                } else {
                    throw UnsupportedOperationException(
                        Book::class.java.name +
                            " must implement Parcelable or Serializable or must be an Enum.")
                }
                if (__currentBook == null) {
                    throw IllegalArgumentException("Argument \"currentBook\" is marked as non-null but was passed a null value.")
                }
            } else {
                throw IllegalArgumentException("Required argument \"currentBook\" is missing and does not have an android:defaultValue")
            }
            return UpdateFragmentArgs(__currentBook)
        }
    }
}
