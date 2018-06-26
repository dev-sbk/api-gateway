package com.epi.pfa.domain;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.Instant;
@Document(collection = "banck_card")
public class BankCard implements Serializable {
   @Id
   private String id;
   @Field("card_number")
   @CreditCardNumber()
   private String cardNumber;
   @Field("card-type")
   private CardType cardType;
   @Field("expried_date")
   private Instant expiredDate=Instant.now();
   @Field("cvc")
   private String cvc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Instant getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Instant expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankCard)) return false;

        BankCard bankCard = (BankCard) o;

        if (getId() != null ? !getId().equals(bankCard.getId()) : bankCard.getId() != null) return false;
        if (getCardNumber() != null ? !getCardNumber().equals(bankCard.getCardNumber()) : bankCard.getCardNumber() != null)
            return false;
        if (getCardType() != bankCard.getCardType()) return false;
        if (getExpiredDate() != null ? !getExpiredDate().equals(bankCard.getExpiredDate()) : bankCard.getExpiredDate() != null)
            return false;
        return getCvc() != null ? getCvc().equals(bankCard.getCvc()) : bankCard.getCvc() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCardNumber() != null ? getCardNumber().hashCode() : 0);
        result = 31 * result + (getCardType() != null ? getCardType().hashCode() : 0);
        result = 31 * result + (getExpiredDate() != null ? getExpiredDate().hashCode() : 0);
        result = 31 * result + (getCvc() != null ? getCvc().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BankCard{" +
            "id='" + id + '\'' +
            ", cardNumber='" + cardNumber + '\'' +
            ", cardType=" + cardType +
            ", expiredDate=" + expiredDate +
            ", cvc='" + cvc + '\'' +
            '}';
    }
}
