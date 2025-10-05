
package com.turkcell.libraryapp.application.command.loan;

public class CreateLoanCommand {
    public final Long studentId;
    public final Long copyBookId;
    public CreateLoanCommand(Long studentId, Long copyBookId){ this.studentId=studentId; this.copyBookId=copyBookId; }
}
