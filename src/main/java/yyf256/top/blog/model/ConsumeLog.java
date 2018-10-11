package yyf256.top.blog.model;

import java.io.Serializable;
import java.util.Date;

public class ConsumeLog implements Serializable {
    private String timeId;

    private Float consumeMoney;

    private Date time;

    private static final long serialVersionUID = 1L;

    public String getTimeId() {
        return timeId;
    }

    public void setTimeId(String timeId) {
        this.timeId = timeId == null ? null : timeId.trim();
    }

    public Float getConsumeMoney() {
        return consumeMoney;
    }

    public void setConsumeMoney(Float consumeMoney) {
        this.consumeMoney = consumeMoney;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ConsumeLog other = (ConsumeLog) that;
        return (this.getTimeId() == null ? other.getTimeId() == null : this.getTimeId().equals(other.getTimeId()))
            && (this.getConsumeMoney() == null ? other.getConsumeMoney() == null : this.getConsumeMoney().equals(other.getConsumeMoney()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTimeId() == null) ? 0 : getTimeId().hashCode());
        result = prime * result + ((getConsumeMoney() == null) ? 0 : getConsumeMoney().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", timeId=").append(timeId);
        sb.append(", consumeMoney=").append(consumeMoney);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}