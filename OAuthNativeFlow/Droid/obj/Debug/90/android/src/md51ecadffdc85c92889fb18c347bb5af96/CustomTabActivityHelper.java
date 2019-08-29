package md51ecadffdc85c92889fb18c347bb5af96;


public class CustomTabActivityHelper
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("Android.Support.CustomTabs.Chromium.SharedUtilities.CustomTabActivityHelper, Xamarin.Auth", CustomTabActivityHelper.class, __md_methods);
	}


	public CustomTabActivityHelper ()
	{
		super ();
		if (getClass () == CustomTabActivityHelper.class)
			mono.android.TypeManager.Activate ("Android.Support.CustomTabs.Chromium.SharedUtilities.CustomTabActivityHelper, Xamarin.Auth", "", this, new java.lang.Object[] {  });
	}

	private java.util.ArrayList refList;
	public void monodroidAddReference (java.lang.Object obj)
	{
		if (refList == null)
			refList = new java.util.ArrayList ();
		refList.add (obj);
	}

	public void monodroidClearReferences ()
	{
		if (refList != null)
			refList.clear ();
	}
}
