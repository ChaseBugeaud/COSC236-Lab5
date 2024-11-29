package lab5;

public class BorrowingBookResult {
  private boolean isSuccess;
  private String borrowingMessage;

  // Constructor
  public BorrowingBookResult(boolean isSuccess,
      String borrowingMessage) {
    this.isSuccess = isSuccess;
    this.borrowingMessage = borrowingMessage;
  }
  // Getters and setters
  // DONE implement getters and setters

  // Mutator methods
  public void setBorrowingMessage(String message) {
    this.borrowingMessage = message;
  }

  public void setSuccessful() {
    this.isSuccess = true;
  }

  public void setFailure() {
    this.isSuccess = false;
  }

  // Accessor methods
  public boolean isSuccess() {
    return this.isSuccess();
  }

  public String getBorrowingMessage() {
    return this.borrowingMessage;
  }

}
