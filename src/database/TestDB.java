package database;

import com.google.gdata.client.GoogleAuthTokenFactory.OAuth2Token;
import com.google.gdata.client.authn.oauth.GoogleOAuthParameters;
import com.google.gdata.client.authn.oauth.OAuthParameters;
import com.google.gdata.client.authn.oauth.OAuthUtil;

public class TestDB {
	public TestDB(){
		GoogleOAuthParameters parameters = new GoogleOAuthParameters();
		parameters.setOAuthConsumerKey("487721949359-r2f72hek2t9it42qr3b9qq2q3dmkkg9u.apps.googleusercontent.com");
		parameters.setOAuthConsumerSecret("mkiUtHCrNqqEZV4j3GbXFxQD");
		parameters.setOAuthCallback("urn:ietf:wg:oauth:2.0:oob");
		parameters.setScope("https://spreadsheets.google.com/feeds");
		
	}
}
