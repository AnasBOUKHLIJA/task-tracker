package com.taskTracker.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BUG")
public class BugTask extends Task {
	
	@Column(name = "severity")
	private String severity;
	
	@Column(name = "steps_to_reproduce")
    private String stepsToReproduce;
	
	//--------------------------------------------------------------------------------------
	// GETTERS AND SETTERS
	//--------------------------------------------------------------------------------------

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getStepsToReproduce() {
		return stepsToReproduce;
	}

	public void setStepsToReproduce(String stepsToReproduce) {
		this.stepsToReproduce = stepsToReproduce;
	}

	private static final long serialVersionUID = 1L;

}
