/*
 * Copyright 2011 the original author or authors.
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
import geb.spock.GebReportingSpec

import spock.lang.*

@Stepwise
class GoogleWikipediaSpec extends GebReportingSpec {
    
    def "go to google"() {
        when:
        go() // uses base url system property
        
        then:
        title == "Google"
    }
    
    def "search for wikipedia"() {
        given:
        q = "wikipedia"
        
        and:
        waitFor { btnG().displayed }
        
        when:
        btnG().click()
        
        then:
        waitFor { title.endsWith("Google Search") }
    }
    
    def "the first result should be wikipedia"() {
        given:
        def firstLink = $("li.g", 0).find("a.l")
        
        expect:
        firstLink.text() == "Wikipedia"
        
        when:
        firstLink.click()
        
        then:
        waitFor { title == "Wikipedia" }
    }
    
}