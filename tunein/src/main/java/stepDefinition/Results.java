package stepDefinition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {

    @JsonProperty("text1")
    String text1;

    @JsonProperty("text2")
    String text2;

    @JsonProperty("text3")
    String text3;

    @JsonProperty("text1href")
    String text1href;

    @JsonProperty("text2href")
    String text2href;

    @JsonProperty("text3href")
    String text3href;

    @JsonProperty("imagehref")
    String imagehref;

    @JsonProperty("timeStamp")
    long timeStamp;

    public void setTimeStamp(long timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public void setText1(String text)
    {
        this.text1 = text;
    }

    public void setText2(String text)
    {
        this.text2 = text;
    }

    public void setText3(String text)
    {
        this.text3 = text;
    }

    public void setText1HREF(String text)
    {
        this.text1href = text;
    }

    public void setText2HREF(String text)
    {
        this.text2href = text;
    }

    public void setText3HREF(String text)
    {
        this.text3href = text;
    }

    public void setImageHREF(String text)
    {
        this.imagehref = text;
    }



}
