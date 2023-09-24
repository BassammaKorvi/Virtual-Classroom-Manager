package virtualclassroom;

public class Assignment {

	    private String AssignmentDetails;
	    
	    //different types of constructor
	    public Assignment(String AssignmentDetails) {
	        this.AssignmentDetails = AssignmentDetails;
	    }
	    public Assignment() {
	    }
	    
	 
	    //getter and setter for all attributes
	    public String getAssignmentDetails() {
	        return AssignmentDetails;
	    }

	    public void setAssignmentDetails(String AssignmentDetails) {
	        this.AssignmentDetails = AssignmentDetails;
	    }

	    @Override
	    public String toString() {
	        return "Assignment{" +
	                ", AssignmentDetails='" + AssignmentDetails + '\'' +
	                '}';
	    }
	}

