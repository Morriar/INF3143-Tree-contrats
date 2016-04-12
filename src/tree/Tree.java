/*
 * Copyright 2015 Alexandre Terrasa <alexandre@moz-code.org>.
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
package tree;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

public interface Tree<E> {

    int size();

    @Ensures("result == (size() == 0)")
    boolean isEmpty();

    boolean hasRoot();

    @Requires("!hasRoot()")
    @Ensures({
        "hasRoot()",
        "size() == old(size()) + 1",})
    void setRoot(E rootValue);

    @Requires("hasRoot()")
    E getRoot();

    @Requires("hasRoot()")
    boolean hasNode(E nodeValue);

    @Requires({
        "hasRoot()",
        "hasNode(parentNodeValue)",
        "!hasNode(nodeValue)"
    })
    @Ensures({
        "hasNode(nodeValue)",
        "size() == old(size()) + 1"
    })
    void addNode(E parentNodeValue, E nodeValue);

}
