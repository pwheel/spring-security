/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
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

package org.springframework.security.web.session;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.session.SessionCreationEvent;

/**
 * Published by the {@link HttpSessionEventPublisher} when an {@code HttpSession} is
 * created by the container
 *
 * @author Ray Krueger
 * @author Luke Taylor
 */
public class HttpSessionCreatedEvent extends SessionCreationEvent {
	// ~ Constructors
	// ===================================================================================================

	public HttpSessionCreatedEvent(HttpSession session) {
		super(session);
	}

	public HttpSession getSession() {
		return (HttpSession) getSource();
	}
}
