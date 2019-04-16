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

import android.app.Fragment
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_section.*
import kotlinx.android.synthetic.main.fragment_section.view.*

/**
 * Basic section container.
 *
 *
 * TODO: Replace these with implementations to match your apps functionality.
 */
class SectionFragment : Fragment() {

    private lateinit var mSection: Section

    enum class Section constructor(internal val titleRes: Int, internal val drawableRes: Int) {
        Sun(R.string.sun_title, R.drawable.ic_sun_black_24dp),
        Moon(R.string.moon_title, R.drawable.ic_moon_black_24dp),
        Earth(R.string.earth_title, R.drawable.ic_earth_black_24dp),
        Settings(R.string.settings_title, R.drawable.ic_settings_black_24dp)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_section, container, false)

        if (arguments != null) {
            mSection = arguments.getSerializable(EXTRA_SECTION) as Section
            val imageDrawable = ContextCompat.getDrawable(context, mSection.drawableRes)
            // use view.{widget} to avoid null pointer exception at runtime
            view.emoji.setImageDrawable(imageDrawable)
            view.title.text = resources.getString(mSection.titleRes)
        }

        return view
    }

    companion object {

        /**
         * Helper method to quickly create sections.
         *
         * @param section The [Section] to use.
         * @return A new SectionFragment with arguments set based on the provided Section.
         */
        fun getSection(section: Section): SectionFragment {
            val newSection = SectionFragment()
            val arguments = Bundle()
            arguments.putSerializable(EXTRA_SECTION, section)
            newSection.arguments = arguments
            return newSection
        }

        val EXTRA_SECTION = "com.example.android.wearable.navaction.EXTRA_SECTION"
    }
}
