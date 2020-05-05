package io.smartnexus.ats.pojo;

public class CompanyOptionExt {
    private String value;

    private String displayName;

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getDisplayName ()
    {
        return displayName;
    }

    public void setDisplayName (String displayName)
    {
        this.displayName = displayName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [value = "+value+", displayName = "+displayName+"]";
    }
}
			
	