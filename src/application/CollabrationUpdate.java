package application;

import java.util.Date;

public class CollabrationUpdate {
    private int updateId;
    private Date creationDate;
    private int associatedServiceReq;
    private int createdByEmployee;
	public int getUpdateId() {
		return updateId;
	}
	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getAssociatedServiceReq() {
		return associatedServiceReq;
	}
	public void setAssociatedServiceReq(int associatedServiceReq) {
		this.associatedServiceReq = associatedServiceReq;
	}
	public int getCreatedByEmployee() {
		return createdByEmployee;
	}
	public void setCreatedByEmployee(int createdByEmployee) {
		this.createdByEmployee = createdByEmployee;
	}

    // Assuming there are methods to be added here.
}