package com.github.mikephil.charting.highlight;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Philipp Jahoda on 24/07/15. Class that represents the range of one value in a stacked bar entry. e.g.
 * stack values are -10, 5, 20 -> then ranges are (-10 - 0, 0 - 5, 5 - 25).
 */
public final class Range implements Parcelable {

	public float from;
	public float to;

	public Range(float from, float to) {
		this.from = from;
		this.to = to;
	}

	/**
	 * Returns true if this range contains (if the value is in between) the given value, false if not.
	 * 
	 * @param value
	 * @return
	 */
	public boolean contains(float value) {

		if (value > from && value <= to)
			return true;
		else
			return false;
	}

	public boolean isLarger(float value) {
		return value > to;
	}

	public boolean isSmaller(float value) {
		return value < from;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeFloat(this.from);
		dest.writeFloat(this.to);
	}

	protected Range(Parcel in) {
		this.from = in.readFloat();
		this.to = in.readFloat();
	}

	public static final Creator<Range> CREATOR = new Creator<Range>() {
		@Override
		public Range createFromParcel(Parcel source) {
			return new Range(source);
		}

		@Override
		public Range[] newArray(int size) {
			return new Range[size];
		}
	};
}