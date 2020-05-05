package io.smartnexus.ats.pojo;

import java.util.List;

public class CompanyOptions {
    private List<Options> Options;

    public List<Options> getOptions ()
    {
        return Options;
    }

    public void setOptions (List<Options> Options)
    {
        this.Options = Options;
    }

    @Override
    public String toString()
    {
        return "CompanyOptions [Options = "+Options+"]";
    }
}