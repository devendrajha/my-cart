package io.smartnexus.ats.pojo;

public class TransitionDetails {
	private Transitions[] transitions;
	private String expand;

	public Transitions[] getTransitions() {
		return transitions;
	}

	public void setTransitions(Transitions[] transitions) {
		this.transitions = transitions;
	}

	public String getExpand() {
		return expand;
	}

	public void setExpand(String expand) {
		this.expand = expand;
	}

	@Override
	public String toString() {
		return "TransitionDetails [transitions = " + transitions + ", expand = " + expand + "]";
	}
}
