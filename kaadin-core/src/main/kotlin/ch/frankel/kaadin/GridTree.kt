/*
 * Copyright 2016 Nicolas Fränkel
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
package ch.frankel.kaadin

import com.vaadin.data.*
import com.vaadin.ui.*

/**
 * see http://demo.vaadin.com/sampler/#ui/grids-and-trees
 */
private fun <S : AbstractSelect> S.process(container: HasComponents,
                                           caption: String?,
                                           dataSource: Container?,
                                           init: S.() -> Unit): S {
    return apply {
        caption?.let { this.caption = caption }
        dataSource?.let { this.containerDataSource = dataSource }
    }
            .apply(init)
            .addTo(container)
}

fun HasComponents.table(caption: String? = null,
                        dataSource: Container? = null,
                        init: Table.() -> Unit = {}) = Table()
        .process(this, caption, dataSource, init)

fun HasComponents.tree(caption: String? = null,
                       dataSource: Container? = null,
                       init: Tree.() -> Unit = {}) = Tree()
        .process(this, caption, dataSource, init)

fun HasComponents.treeTable(caption: String? = null,
                            dataSource: Container? = null,
                            init: TreeTable.() -> Unit = {}) = TreeTable()
        .process(this, caption, dataSource, init)

fun HasComponents.grid(caption: String? = null,
                       dataSource: Container.Indexed? = null,
                       init: Grid.() -> Unit = {}): Grid {
    return Grid()
            .apply {
                caption?.let { this.caption = caption }
                dataSource?.let { this.containerDataSource = dataSource }
            }
            .apply(init)
            .addTo(this)
}