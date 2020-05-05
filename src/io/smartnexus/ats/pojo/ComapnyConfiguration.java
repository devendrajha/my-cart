package io.smartnexus.ats.pojo;

public class ComapnyConfiguration {
    private String id;

    private String displayName;

    private CompanyOptionExt[] optionExt;

    private String isEditable;

    private String[] options;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getDisplayName ()
    {
        return displayName;
    }

    public void setDisplayName (String displayName)
    {
        this.displayName = displayName;
    }

    public CompanyOptionExt[] getOptionExt ()
    {
        return optionExt;
    }

    public void setOptionExt (CompanyOptionExt[] optionExt)
    {
        this.optionExt = optionExt;
    }

    public String getIsEditable ()
    {
        return isEditable;
    }

    public void setIsEditable (String isEditable)
    {
        this.isEditable = isEditable;
    }

    public String[] getOptions ()
    {
        return options;
    }

    public void setOptions (String[] options)
    {
        this.options = options;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", displayName = "+displayName+", optionExt = "+optionExt+", isEditable = "+isEditable+", options = "+options+"]";
    }
}