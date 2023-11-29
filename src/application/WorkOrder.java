package application;

public class WorkOrder {
    private int workOrderId;
    private int deadline;
    private int creationDate;
    private int associatedServiceReq;
    private int assignedResources;

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public void assignResources(int resources) {
        this.assignedResources = resources;
    }

	public int getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(int workOrderId) {
		this.workOrderId = workOrderId;
	}

	public int getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(int creationDate) {
		this.creationDate = creationDate;
	}

	public int getAssociatedServiceReq() {
		return associatedServiceReq;
	}

	public void setAssociatedServiceReq(int associatedServiceReq) {
		this.associatedServiceReq = associatedServiceReq;
	}

	public int getAssignedResources() {
		return assignedResources;
	}

	public void setAssignedResources(int assignedResources) {
		this.assignedResources = assignedResources;
	}

	public int getDeadline() {
		return deadline;
	}
}