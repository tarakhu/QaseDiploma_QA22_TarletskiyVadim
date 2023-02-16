package models;

import enums.*;
import lombok.Getter;

import java.util.Objects;

@Getter
public class TestCase {

    private final String title;
    private final String description;
    private final String preConditions;
    private final String postConditions;
    private final AutomationStatus automationStatus;
    private final Behavior behavior;
    private final IsFlaky isFlaky;
    private final Layer layer;
    private final Priority priority;
    private final Severity severity;
    private final Status status;
    private final Type type;

    private TestCase(TestCaseBuilder testCaseBuilder) {
        this.title = testCaseBuilder.title;
        this.description = testCaseBuilder.description;
        this.preConditions = testCaseBuilder.preConditions;
        this.postConditions = testCaseBuilder.postConditions;
        this.automationStatus = testCaseBuilder.automationStatus;
        this.behavior = testCaseBuilder.behavior;
        this.isFlaky = testCaseBuilder.isFlaky;
        this.layer = testCaseBuilder.layer;
        this.priority = testCaseBuilder.priority;
        this.severity = testCaseBuilder.severity;
        this.status = testCaseBuilder.status;
        this.type = testCaseBuilder.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCase testCase = (TestCase) o;
        return Objects.equals(title, testCase.title)
                && Objects.equals(description, testCase.description)
                && Objects.equals(preConditions, testCase.preConditions)
                && Objects.equals(postConditions, testCase.postConditions)
                && Objects.equals(automationStatus, testCase.automationStatus)
                && Objects.equals(behavior, testCase.behavior)
                && Objects.equals(isFlaky, testCase.isFlaky)
                && Objects.equals(layer, testCase.layer)
                && Objects.equals(priority, testCase.priority)
                && Objects.equals(severity, testCase.severity)
                && Objects.equals(status, testCase.status)
                && Objects.equals(type, testCase.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, preConditions, postConditions, automationStatus, behavior, isFlaky,
                layer, priority, severity, status, type);
    }

    public static class TestCaseBuilder {
        private String title;
        private String description;
        private String preConditions;
        private String postConditions;
        private AutomationStatus automationStatus;
        private Behavior behavior;
        private IsFlaky isFlaky;
        private Layer layer;
        private Priority priority;
        private Severity severity;
        private Status status;
        private Type type;


        public TestCaseBuilder(String title, Status status, Severity severity, Priority priority, Type type, Layer layer,
                               IsFlaky isFlaky, Behavior behavior, AutomationStatus automationStatus) {
            this.title = title;
            this.status = status;
            this.severity = severity;
            this.priority = priority;
            this.type = type;
            this.layer = layer;
            this.isFlaky = isFlaky;
            this.behavior = behavior;
            this.automationStatus = automationStatus;
        }

        public TestCaseBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public TestCaseBuilder setPreConditions(String preConditions) {
            this.preConditions = preConditions;
            return this;
        }

        public TestCaseBuilder setPostConditions(String postConditions) {
            this.postConditions = postConditions;
            return this;
        }

        public TestCase build() {
            return new TestCase(this);
        }
    }
}
