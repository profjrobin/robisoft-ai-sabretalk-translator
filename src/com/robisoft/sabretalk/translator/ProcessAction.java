package com.robisoft.sabretalk.translator;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;


public class ProcessAction {

	public String previousURL=null, currentURL=null;
	private boolean AbortFlag;
	private boolean active=false;
	private boolean pause=false;
  
  
  /**
   * Generic method to send each line to the OpenAI API
   * 
   */
  public String executeAPI(String prompt,String inputStr) {	 
      StringBuilder payload = new StringBuilder(prompt + ":" + inputStr);
      OpenAIClient client = OpenAIOkHttpClient.fromEnv();

      ResponseCreateParams params = ResponseCreateParams.builder()
              .input(payload.toString())
              .model("gpt-5.5")
              .build();

      Response response = client.responses().create(params);
      //return the response
      System.out.println(response.output().get(1).message().get().content().get(0).outputText().toString());
      return(response.toString());
      //      return(response.output().get(1).message().get().content().get(0).outputText().toString());

  }	  

 
   //Getters and Setters
  //-----------------------------------------------------
  public boolean isAbortFlag() {
	  return(AbortFlag);
  }
  
  public void setAbortFlag(boolean flag) {
	  AbortFlag = flag;
  }
   public boolean isActive() {
	  return(active);
  }
  
  public void setActive(boolean flag) {
	  active = flag;
  }
  public boolean isPause() {
	  return(pause);
  }
  
  public void setPause(boolean flag) {
	  pause = flag;
  }
  
}
