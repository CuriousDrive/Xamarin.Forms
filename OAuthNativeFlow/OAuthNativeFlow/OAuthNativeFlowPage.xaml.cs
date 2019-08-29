using System;
using System.Linq;
using System.Diagnostics;
using Newtonsoft.Json;
using Xamarin.Forms;
using Xamarin.Auth;
using System.Net.Http;

namespace OAuthNativeFlow
{
    public partial class OAuthNativeFlowPage : ContentPage
    {
        Account account;
        [Obsolete]
        AccountStore store;

        [Obsolete]
        public OAuthNativeFlowPage()
        {
            InitializeComponent();

            store = AccountStore.Create();
        }

        [Obsolete]
        void OnGoogleLoginClicked(object sender, EventArgs e)
        {
            string clientId = null;
			string redirectUri = null;

			switch (Device.RuntimePlatform)
			{
				case Device.iOS:
					clientId = Constants.GoogleiOSClientId;
					redirectUri = Constants.GoogleiOSRedirectUrl;
					break;

				case Device.Android:
					clientId = Constants.GoogleAndroidClientId;
					redirectUri = Constants.GoogleAndroidRedirectUrl;
					break;
			}

            account = store.FindAccountsForService(Constants.AppName).FirstOrDefault();

            var authenticator = new OAuth2Authenticator(
				clientId,
				null,
				Constants.GoogleScope,
				new Uri(Constants.GoogleAuthorizeUrl),
				new Uri(redirectUri),
				new Uri(Constants.GoogleAccessTokenUrl),
				null,
				true);

			authenticator.Completed += OnAuthCompleted;
			authenticator.Error += OnAuthError;

			AuthenticationState.Authenticator = authenticator;

			var presenter = new Xamarin.Auth.Presenters.OAuthLoginPresenter();
			presenter.Login(authenticator);
        }

        [Obsolete]
        void OnFacebookLoginClicked(object sender, EventArgs e)
        {
            string clientId = null;
            string redirectUri = null;

            switch (Device.RuntimePlatform)
            {
                case Device.iOS:
                    clientId = Constants.FacebookiOSClientId;
                    redirectUri = Constants.FacebookiOSRedirectUrl;
                    break;

                case Device.Android:
                    clientId = Constants.FacebookAndroidClientId;
                    redirectUri = Constants.FacebookAndroidRedirectUrl;
                    break;
            }

            account = store.FindAccountsForService(Constants.AppName).FirstOrDefault();

            var authenticator = new OAuth2Authenticator(
                clientId,                
                Constants.FacebookScope,
                new Uri(Constants.FacebookAuthorizeUrl),                
                new Uri(Constants.FacebookAccessTokenUrl),
                null);

            authenticator.Completed += OnAuthCompleted;
            authenticator.Error += OnAuthError;

            AuthenticationState.Authenticator = authenticator;

            var presenter = new Xamarin.Auth.Presenters.OAuthLoginPresenter();
            presenter.Login(authenticator);
        }

        [Obsolete]
        async void OnAuthCompleted(object sender, AuthenticatorCompletedEventArgs e)
		{
			var authenticator = sender as OAuth2Authenticator;
			if (authenticator != null)
			{
				authenticator.Completed -= OnAuthCompleted;
				authenticator.Error -= OnAuthError;
			}

            User user = null;
			if (e.IsAuthenticated)
			{
                if (authenticator.AuthorizeUrl.Host == "www.facebook.com")
                {
                    var httpClient = new HttpClient();
                    
                    var json = await httpClient.GetStringAsync($"https://graph.facebook.com/me?fields=email&access_token=" + e.Account.Properties["access_token"]);

                    FacebookEmail facebookEmail = JsonConvert.DeserializeObject<FacebookEmail>(json);

                    await store.SaveAsync(account = e.Account, Constants.AppName);
                    await DisplayAlert("Email address", facebookEmail.Email, "OK");
                }
                else
                {
                    // If the user is authenticated, request their basic user data from Google
                    // UserInfoUrl = https://www.googleapis.com/oauth2/v2/userinfo
                    var request = new OAuth2Request("GET", new Uri(Constants.GoogleUserInfoUrl), null, e.Account);
                    var response = await request.GetResponseAsync();
                    if (response != null)
                    {
                        // Deserialize the data and store it in the account store
                        // The users email address will be used to identify data in SimpleDB
                        string userJson = await response.GetResponseTextAsync();
                        user = JsonConvert.DeserializeObject<User>(userJson);
                    }

                    if (account != null)
                    {
                        store.Delete(account, Constants.AppName);
                    }

                    await store.SaveAsync(account = e.Account, Constants.AppName);
                    await DisplayAlert("Email address", user.Email, "OK");
                } 
			}
		}

        [Obsolete]
        void OnAuthError(object sender, AuthenticatorErrorEventArgs e)
		{
			var authenticator = sender as OAuth2Authenticator;
			if (authenticator != null)
			{
				authenticator.Completed -= OnAuthCompleted;
				authenticator.Error -= OnAuthError;
			}

			Debug.WriteLine("Authentication error: " + e.Message);
		}
    }
}
