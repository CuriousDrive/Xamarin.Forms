package crc643f46942d9dd1fff9;


public class SelectableItemsViewAdapter
	extends crc643f46942d9dd1fff9.ItemsViewAdapter
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onBindViewHolder:(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V:GetOnBindViewHolder_Landroid_support_v7_widget_RecyclerView_ViewHolder_IHandler\n" +
			"n_onViewRecycled:(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V:GetOnViewRecycled_Landroid_support_v7_widget_RecyclerView_ViewHolder_Handler\n" +
			"";
		mono.android.Runtime.register ("Xamarin.Forms.Platform.Android.SelectableItemsViewAdapter, Xamarin.Forms.Platform.Android", SelectableItemsViewAdapter.class, __md_methods);
	}


	public SelectableItemsViewAdapter ()
	{
		super ();
		if (getClass () == SelectableItemsViewAdapter.class)
			mono.android.TypeManager.Activate ("Xamarin.Forms.Platform.Android.SelectableItemsViewAdapter, Xamarin.Forms.Platform.Android", "", this, new java.lang.Object[] {  });
	}


	public void onBindViewHolder (android.support.v7.widget.RecyclerView.ViewHolder p0, int p1)
	{
		n_onBindViewHolder (p0, p1);
	}

	private native void n_onBindViewHolder (android.support.v7.widget.RecyclerView.ViewHolder p0, int p1);


	public void onViewRecycled (android.support.v7.widget.RecyclerView.ViewHolder p0)
	{
		n_onViewRecycled (p0);
	}

	private native void n_onViewRecycled (android.support.v7.widget.RecyclerView.ViewHolder p0);

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
