package com.zemoso.springboot.springbootassignment.entity;

import com.zemoso.springboot.springbootassignment.service.validation.ProcedureCode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="claims")
public class Claim {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message="is required")
    @Column(name="claim_id",unique = true)
    private int claimId;

    @NotNull(message="is required")
    @NotEmpty(message = "is required")
    @Column(name="procedure_code")
    @ProcedureCode(message="must start with ICD-")
    private String procedureCode;

    @NotNull(message="is required ")
    @NotEmpty(message = "is required")
    @Column(name="procedure_code_description")
    private String procedureCodeDescription;

    @NotNull(message="is required / provider is not present please add provider")

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="provider_id")
    private Provider providerId;


    @Column(name="date_of_service")
    private LocalDate dateOfService;


    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @NotNull(message="is required / User is not present please add User")
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User userId;


    @NotNull(message="is required")
    @Min(value=1, message="must be greater than 0")
    @Column(name="cost")
    private int cost;

    @Column(name="created_at")
    private Date createdAt;

    public Claim() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public String getProcedureCodeDescription() {
        return procedureCodeDescription;
    }

    public void setProcedureCodeDescription(String procedureCodeDescription) {
        this.procedureCodeDescription = procedureCodeDescription;
    }


    public Provider getProviderId() {
        return providerId;
    }

    public void setProviderId(Provider providerId) {
        this.providerId = providerId;
    }





    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDateOfService() {
        return dateOfService;
    }

    public void setDateOfService(LocalDate dateOfService) {
        this.dateOfService = dateOfService;
    }



    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }


    public Claim(@NotNull(message = "is required") int claimId, @NotNull(message = "is required") @NotEmpty(message = "is required") String procedureCode, @NotNull(message = "is required ") @NotEmpty(message = "is required") String procedureCodeDescription, @NotNull(message = "is required / provider is not present please add provider") Provider providerId, LocalDate dateOfService, @NotNull(message = "is required / User is not present please add User") User userId, @NotNull(message = "is required") @Min(value = 1, message = "must be greater than 0") int cost, Date createdAt) {
        this.claimId = claimId;
        this.procedureCode = procedureCode;
        this.procedureCodeDescription = procedureCodeDescription;
        this.providerId = providerId;
        this.dateOfService = dateOfService;
        this.userId = userId;
        this.cost = cost;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id=" + id +
                ", claimId=" + claimId +
                ", procedureCode='" + procedureCode + '\'' +
                ", procedureCodeDescription='" + procedureCodeDescription + '\'' +
                ", providerId=" + providerId +
                ", dateOfService=" + dateOfService +
                ", userId=" + userId +
                ", cost=" + cost +
                ", createdAt=" + createdAt +
                '}';
    }
}
