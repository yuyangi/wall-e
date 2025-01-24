package org.free13.rubik.codable.java;

import org.free13.rubik.codable.java.enums.CodeState;
import org.free13.rubik.codable.java.enums.CommentType;

import static org.free13.rubik.codable.java.JKeyword.WRAP;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JComment extends AbsJCode {

    private String comment;
    private CommentType commentType;

    // builder
    public static class Builder {
        private String comment;
        private CommentType commentType;

        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder commentType(CommentType commentType) {
            this.commentType = commentType;
            return this;
        }

        public JComment build() {
            return new JComment(this);
        }
    }
    public static Builder builder() {
        return new Builder();
    }
    public JComment(Builder builder) {
        this.comment = builder.comment;
        this.commentType = builder.commentType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }

    @Override
    public String toCode(String... params) {
        StringBuilder sb = new StringBuilder();
        if (comment == null) {
            return "";
        }
        String[] comments = comment.split(WRAP.simpleName());
        if (commentType == CommentType.BLOCK) {
            sb.append(JKeyword.COMMENT_JAVADOC_START.keyword()).append(WRAP.keyword());
            for (String comment : comments) {
                sb.append(JKeyword.COMMENT_BLOCK_LINE.keyword());
                sb.append(comment);
                sb.append(WRAP.keyword());
            }
            sb.append(JKeyword.COMMENT_JAVADOC_END.keyword());
        } else if (commentType == CommentType.JAVADOC) {
            sb.append(JKeyword.COMMENT_BLOCK_START.keyword()).append(WRAP.keyword());
            for (String comment : comments) {
                sb.append(JKeyword.COMMENT_BLOCK_LINE.keyword());
                sb.append(comment);
                sb.append(WRAP.keyword());
            }
            sb.append(JKeyword.COMMENT_BLOCK_END.keyword());
        } else if (commentType == CommentType.LINE) {
            for (String comment : comments) {
                sb.append(JKeyword.COMMENT_LINE.keyword());
                sb.append(comment);
                sb.append(WRAP.keyword());
            }
        }
        return sb.toString();
    }


    @Override
    public String name() {
        return "";
    }

    @Override
    public String simpleName() {
        return "";
    }

    @Override
    public CodeState codeState() {
        return CodeState.COMPLETE;
    }

    public static JComment of(String comment, CommentType commentType) {
        return JComment.builder().comment(comment).commentType(commentType).build();
    }

}
