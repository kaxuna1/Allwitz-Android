package technonet.com.allwitz.Models;

import java.util.List;

/**
 * Created by vakhtanggelashvili on 4/12/17.
 */

public class Order {
    private long id;

    private String uuid;

    private boolean confirmed;

    private List<BookedTime> bookedTimes;

    private float price;


    private long studentId;

    private boolean CanBePaid;

    private String teacherId;

    private String TeacherName;

    private String studentName;

    public Order() {
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public List<BookedTime> getBookedTimes() {
        return bookedTimes;
    }

    public void setBookedTimes(List<BookedTime> bookedTimes) {
        this.bookedTimes = bookedTimes;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public boolean isCanBePaid() {
        return CanBePaid;
    }

    public void setCanBePaid(boolean canBePaid) {
        CanBePaid = canBePaid;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
