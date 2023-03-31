//package com.example.databasgui_ny.entities;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "Payment")
//public class Payment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int payment_id;
//    /*@Column(name = "customer_id", length = 255)
//    private String customer_id;
//    @Column(name = "staff_id", length = 255)
//    private String staff_id;*/
//    @Column(name = "rental_id", length = 255)
//    private String rental_id;
//    @Column(name = "amount", length = 255)
//    private String amount;
//    @Column(name = "payment_date", length = 60)
//    private String payment_date;
//    @Column(name = "last_update", length = 60)
//    private String last_update;
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
//    private Customer customer;
//
////    @ManyToOne
////    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
////    private Staff staff;
//
//    public Payment(){}
//
//    public int getPayment_id() {return payment_id;}
//
//    public void setPayment_id(int payment_id) {this.payment_id = payment_id;}
//
//    public Customer getCustomer_id() {return customer;}
//
//    public void setCustomer_id(String customer_id) {this.customer = customer;}
//
////    public Staff getStaff_id() {return staff;}
////
////    public void setStaff_id(String staff_id) {this.staff = staff;}
//
//    public String getRental_id() {return rental_id;}
//
//    public void setRental_id(String rental_id) {this.rental_id = rental_id;}
//
//    public String getAmount() {return amount;}
//
//    public void setAmount(String amount) {this.amount = amount;}
//
//    public String getPayment_date() {return payment_date;}
//
//    public void setPayment_date(String payment_date) {this.payment_date = payment_date;}
//
//    public String getLast_update() {return last_update;}
//
//    public void setLast_update(String last_update) {this.last_update = last_update;}
//}
