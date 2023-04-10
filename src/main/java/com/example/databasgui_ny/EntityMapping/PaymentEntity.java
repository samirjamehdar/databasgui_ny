package com.example.databasgui_ny.EntityMapping;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "payment", schema = "sakila", catalog = "")
public class PaymentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "payment_id", nullable = false)
    private int paymentId;
//    @Basic
//    @Column(name = "customer_id", nullable = false)
//    private Object customerId;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerId;
//    @Basic
//    @Column(name = "staff_id", nullable = false)
//    private Object staffId;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    private StaffEntity staffId;
    @Basic
    @Column(name = "rental_id", nullable = true)
    private Integer rentalId;
    @Basic
    @Column(name = "amount", nullable = false, precision = 2)
    private BigDecimal amount;
    @Basic
    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;
    @Basic
    @Column(name = "last_update", nullable = true)
    private Timestamp lastUpdate;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public CustomerEntity getCustomer() {return customerId;}

    public void setCustomer(CustomerEntity customerId) {
        this.customerId = customerId;
    }
    public Integer getCustomerId() {return getCustomer().getCustomerId();}
    public void setCustomerId(Integer customerId) {getCustomer().setCustomerId(customerId);}

    public StaffEntity getStaff() {
        return staffId;
    }

    public void setStaff(StaffEntity staffId) {
        this.staffId = staffId;
    }
    public void setStaffId( Integer staffId) {getStaff().setStaffId(staffId);}

    public Integer getStaffId() {return getStaff().getStaffId();}

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return Objects.equals(paymentId, that.paymentId) && Objects.equals(customerId, that.customerId) && Objects.equals(staffId, that.staffId) && Objects.equals(rentalId, that.rentalId) && Objects.equals(amount, that.amount) && Objects.equals(paymentDate, that.paymentDate) && Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, customerId, staffId, rentalId, amount, paymentDate, lastUpdate);
    }
}
