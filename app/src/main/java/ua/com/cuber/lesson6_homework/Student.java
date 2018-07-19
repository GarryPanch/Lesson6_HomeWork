package ua.com.cuber.lesson6_homework;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    String FirstName;
    String LastName;
    int Age;

    public Student(){

    }

    public Student(String firstName, String lastName, int age){
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.FirstName);
        dest.writeString(this.LastName);
        dest.writeInt(this.Age);
    }

    protected Student(Parcel in) {
        this.FirstName = in.readString();
        this.LastName = in.readString();
        this.Age = in.readInt();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
