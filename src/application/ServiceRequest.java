package application;

public class ServiceRequest {
    private String status;
    private int requestId;
    private String serviceType;
    private String description;
    private int assignedDepartment;

    public void trackServiceRequest() {
        // Implementation code here
    }

    public void updateStatus() {
        // Implementation code here
    }

    public void addCollaborationNote() {
        // Implementation code here
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAssignedDepartment() {
		return assignedDepartment;
	}

	public void setAssignedDepartment(int assignedDepartment) {
		this.assignedDepartment = assignedDepartment;
	}
}
