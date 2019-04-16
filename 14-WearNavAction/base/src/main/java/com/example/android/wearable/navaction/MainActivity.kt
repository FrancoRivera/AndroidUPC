/*
Copyright 2017 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.example.android.wearable.navaction

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.support.wearable.view.drawer.WearableActionDrawer
import android.support.wearable.view.drawer.WearableNavigationDrawer
import android.view.MenuItem
import android.widget.Toast
import com.example.android.wearable.navaction.SectionFragment.Section
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        top_navigation_drawer.setAdapter(NavigationAdapter(this))


        val sunSection = SectionFragment.getSection(DEFAULT_SECTION)
        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, sunSection)
                .commit()

        bottom_action_drawer.setOnMenuItemClickListener(
                object:WearableActionDrawer.OnMenuItemClickListener {
            override fun onMenuItemClick(menuItem: MenuItem): Boolean {
              bottom_action_drawer.closeDrawer()
                when(menuItem.itemId){
                    R.id.action_edit -> {
                        Toast.makeText(
                                this@MainActivity,
                                R.string.action_edit_todo,
                                Toast.LENGTH_SHORT)
                                .show()
                        return true
                    }
                    R.id.action_share -> {
                        Toast.makeText(
                                this@MainActivity,
                                R.string.action_share_todo,
                                Toast.LENGTH_SHORT)
                                .show()
                        return true
                    }
                }
                return false
            }
        })

    }

    private inner class NavigationAdapter(private val context: Context) :
            WearableNavigationDrawer.WearableNavigationDrawerAdapter() {

        var currentSection: Section = DEFAULT_SECTION

        override fun getItemText(i: Int): String? = context.getString(Section.values()[i].titleRes)

        override fun getItemDrawable(i: Int): Drawable? = context.getDrawable(Section.values()[i].drawableRes)

        override fun onItemSelected(i: Int) {
            var selectedSection = Section.values()[i]
            if(selectedSection == currentSection)
                return
            currentSection = selectedSection

            val sectionFragment = SectionFragment.getSection(currentSection)

            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, sectionFragment)
                    .commit()
            if (selectedSection == SectionFragment.Section.Settings) {
                bottom_action_drawer.lockDrawerClosed()
            } else {
                bottom_action_drawer.unlockDrawer()
            }
        }

        override fun getCount(): Int = Section.values().size
    }

    companion object {
        private val DEFAULT_SECTION = Section.Sun
    }

}
