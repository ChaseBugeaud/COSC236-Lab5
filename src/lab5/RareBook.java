package lab5;

public class RareBook implements Book {

  private String title;
  private boolean isAvailable;

  public RareBook(String title) {
    this.title = title;
    this.isAvailable = true;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String toString() {
    return "Rare Book: " + title;
  }

  public void setIsAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public boolean getIsAvailable() {
    return isAvailable;
  }

}
