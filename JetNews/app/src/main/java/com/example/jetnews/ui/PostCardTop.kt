/*
 * Copyright 2019 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetnews.ui

import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.composer
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.Padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.material.themeTextStyle
import androidx.ui.material.withOpacity
import com.android.tools.preview.Preview

@Composable
fun PostCardTop(post: Post) {
    // TUTORIAL CONTENT STARTS HERE
    Padding(16.dp) {
        Column(crossAxisSize = LayoutSize.Expand) {
            post.image?.let {
                Container(expanded = true, height = 180.dp) {
                    Clip(shape = RoundedCornerShape(4.dp)) {
                        DrawImage(it)
                    }
                }
            }
            HeightSpacer(16.dp)
            Text(
                text = post.title,
                style = (+themeTextStyle { h6 }).withOpacity(0.87f)
            )
            Text(
                text = post.metadata.author.name,
                style = (+themeTextStyle { body2 }).withOpacity(0.87f)
            )
            Text(
                text = "${post.metadata.date} - ${post.metadata.readTimeMinutes} min read",
                style = (+themeTextStyle { body2 }).withOpacity(0.6f)
            )
        }
    }
    // TUTORIAL CONTENT ENDS HERE
}

// Preview section

@Preview("Default colors")
@Composable
fun TutorialPreview() {
    val context = +ambient(ContextAmbient)
    val previewPosts = getPostsWithImagesLoaded(posts.subList(1, 2), context.resources)
    val post = previewPosts[0]
    MaterialTheme(colors = lightThemeColors) {
        Surface {
            PostCardTop(post)
        }
    }
}

@Preview("Dark colors")
@Composable
fun TutorialPreviewDark() {
    val context = +ambient(ContextAmbient)
    val previewPosts = getPostsWithImagesLoaded(posts.subList(1, 2), context.resources)
    val post = previewPosts[0]
    MaterialTheme(colors = darkThemeColors) {
        Surface {
            PostCardTop(post)
        }
    }
}

@Preview("Font scaling 1.5", fontScale = 1.5f)
@Composable
fun TutorialPreviewFontscale() {
    val context = +ambient(ContextAmbient)
    val previewPosts = getPostsWithImagesLoaded(posts.subList(1, 2), context.resources)
    val post = previewPosts[0]
    MaterialTheme(colors = lightThemeColors) {
        Surface {
            PostCardTop(post)
        }
    }
}