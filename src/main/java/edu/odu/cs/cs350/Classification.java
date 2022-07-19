package edu.odu.cs.cs350;

/*
 * Enum class to classify HTML tags.
 * INTERNAL  - link that references a part of the current document.
 * INTRAPAGE - link that references another part of the same site.
 * EXTERNAL  - link that references another site.
 */

public enum Classification {
    INTERNAL,
    INTRAPAGE,
    EXTERNAL
}
