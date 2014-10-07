package org.laybe.proxymate.android.activities.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.contrib.DrawerActions.closeDrawer;
import static com.google.android.apps.common.testing.ui.espresso.contrib.DrawerActions.openDrawer;
import static com.google.android.apps.common.testing.ui.espresso.contrib.DrawerMatchers.isClosed;
import static com.google.android.apps.common.testing.ui.espresso.contrib.DrawerMatchers.isOpen;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

import org.laybe.proxymate.R;
import org.laybe.proxymate.android.activities.MainActivityImpl;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

@LargeTest
public class MainActivityTest  extends ActivityInstrumentationTestCase2<MainActivityImpl> {

	public MainActivityTest() {
		super(MainActivityImpl.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getActivity();
	}

	public void testOpenAndCloseDrawer() {
		// Drawer should not be open to start.
		onView(withId(R.id.drawer_layout)).check(matches(isClosed()));

		openDrawer(R.id.drawer_layout);

		// The drawer should now be open.
		onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

		closeDrawer(R.id.drawer_layout);

		// Drawer should be closed again.
		onView(withId(R.id.drawer_layout)).check(matches(isClosed()));
	}

}