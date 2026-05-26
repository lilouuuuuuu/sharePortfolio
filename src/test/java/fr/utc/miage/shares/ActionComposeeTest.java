/*
 * Copyright 2025 David Navarre &lt;David.Navarre at irit.fr&gt;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.utc.miage.shares;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ActionComposeeTest {
    private static final String ACTION_COMPOSEE = "Action Composee";
    private static final String ACTION_AIRBUS = "Action Airbus";
    private static final String ACTION_ORANGE = "Action Orange";
    private static final float PART_ACTION_AIRBUS = 30.0f;
    private static final float PART_ACTION_COMPLETE = 100.0f;
    private static final float PART_ACTION_ORANGE = 70.0f;
    
    @Test
    void testConstructeurDoesWork() {
        ActionSimple actionSimple = new ActionSimple(ACTION_AIRBUS);
        HashMap<Action, Float> actions = new HashMap<>();
        actions.put(actionSimple, PART_ACTION_COMPLETE);
        
        assertDoesNotThrow(() -> new ActionComposee(ACTION_COMPOSEE, actions));
    }

    @Test
    void testConstructeurWithNullActions() {
        assertThrows(IllegalArgumentException.class, () -> new ActionComposee(ACTION_COMPOSEE, null));
    }

    @Test
    void testActionComposeeEqualsWithSameObject() {
       ActionSimple actionSimple = new ActionSimple(ACTION_AIRBUS);
        HashMap<Action, Float> actions = new HashMap<>();
        actions.put(actionSimple, PART_ACTION_COMPLETE); 

        ActionComposee actionComposee = new ActionComposee(ACTION_COMPOSEE, actions);
        ActionComposee actionComposee2 = new ActionComposee(ACTION_COMPOSEE, actions);
        Boolean result = actionComposee.equals(actionComposee2);
        assertTrue(result);
    }

    @Test
    void testActionComposeeDoesNotEqualsWithActionSimple() {
        ActionSimple actionSimple = new ActionSimple(ACTION_AIRBUS);
        HashMap<Action, Float> actions = new HashMap<>();
        actions.put(actionSimple, PART_ACTION_COMPLETE);
        
        ActionComposee actionComposee = new ActionComposee(ACTION_COMPOSEE, actions);
        Boolean result = actionComposee.equals(actionSimple);
        assertFalse(result);
    }

    @Test
    void testEqualsWithNull() {
        ActionSimple actionSimple = new ActionSimple(ACTION_AIRBUS);
        HashMap<Action, Float> actions = new HashMap<>();
        actions.put(actionSimple, PART_ACTION_COMPLETE);
        
        ActionComposee actionComposee = new ActionComposee(ACTION_COMPOSEE, actions);
        Boolean result = actionComposee.equals(null);
        assertFalse(result);
    }

    @Test
    void testGetActions() {
        ActionSimple actionSimple = new ActionSimple(ACTION_AIRBUS);
        HashMap<Action, Float> actions = new HashMap<>();
        actions.put(actionSimple, PART_ACTION_COMPLETE);
        
        ActionComposee actionComposee = new ActionComposee(ACTION_COMPOSEE, actions);
        Map<Action, Float> result = actionComposee.getActions();
        assertEquals(actions, result);
    }

    @Test
    void testSetActions() {
        ActionSimple actionSimple = new ActionSimple(ACTION_AIRBUS);
        HashMap<Action, Float> actions = new HashMap<>();
        actions.put(actionSimple, PART_ACTION_COMPLETE);
        ActionComposee actionComposee = new ActionComposee(ACTION_COMPOSEE, actions);
        Map<Action, Float> result = actionComposee.getActions();
        assertEquals(actions, result);
        HashMap<Action, Float> newActions = new HashMap<>();
        ActionSimple actionSimple2 = new ActionSimple(ACTION_ORANGE);
        newActions.put(actionSimple2, PART_ACTION_ORANGE);
        actionComposee.setActions(newActions);
        result = actionComposee.getActions();
        assertEquals(newActions, result);
    }

    @Test
    void testValeur() {
        HashMap<Action, Float> actions = new HashMap<>();
        ActionSimple actionSimple = new ActionSimple(ACTION_AIRBUS);
        actions.put(actionSimple, PART_ACTION_COMPLETE);
        ActionComposee actionComposee = new ActionComposee(ACTION_COMPOSEE, actions);
        float result = actionComposee.valeur(new Jour(2025, 1, 1));
        assertEquals(PART_ACTION_AIRBUS * actionSimple.valeur(new Jour(2025, 1, 1)), result);
    }

    @Test
    void testSetActionsWithNull() {
        ActionSimple actionSimple = new ActionSimple(ACTION_AIRBUS);
        HashMap<Action, Float> actions = new HashMap<>();
        actions.put(actionSimple, PART_ACTION_COMPLETE);
        ActionComposee actionComposee = new ActionComposee(ACTION_COMPOSEE, actions);
        assertThrows(IllegalArgumentException.class, () -> actionComposee.setActions(null));
    }
}
