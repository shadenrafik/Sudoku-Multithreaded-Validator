public class ValidationResult {
         private final boolean valid;
         private final int index;
         private final String type;
         private final int duplicated;
         public ValidationResult(boolean valid, int index, String type, int duplicated) {
             this.valid = valid;
             this.index = index;
             this.type = type;
             this.duplicated = duplicated;
         }
         public boolean isValid() {return valid;}
    public String toString(){
             if (valid) return "";
             return type+" "+index+", #"+duplicated;
    }
}
