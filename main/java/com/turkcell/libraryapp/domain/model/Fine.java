
package com.turkcell.libraryapp.domain.model;

public class Fine {
    private Long id;
    private Long loanId;
    private double amount;

    public Fine(Long id, Long loanId, double amount){ this.id=id; this.loanId=loanId; this.amount=amount; }
    public Long getId(){ return id; }
    public Long getLoanId(){ return loanId; }
    public double getAmount(){ return amount; }
}
