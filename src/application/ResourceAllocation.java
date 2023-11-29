package application;

import java.util.Date;

public class ResourceAllocation {
    private int allocationId;
    private String resourceType;
    private int associatedServiceReq;
    private int assignedDept;
    private int quantity;
    private Date allocationDate;

    public void trackResourceUsage() {
        // Implementation code here
    }

    public void updateAllocation() {
        // Implementation code here
    }

	public int getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public int getAssociatedServiceReq() {
		return associatedServiceReq;
	}

	public void setAssociatedServiceReq(int associatedServiceReq) {
		this.associatedServiceReq = associatedServiceReq;
	}

	public int getAssignedDept() {
		return assignedDept;
	}

	public void setAssignedDept(int assignedDept) {
		this.assignedDept = assignedDept;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(Date allocationDate) {
		this.allocationDate = allocationDate;
	}
}