package org.free13.rubik.coder.struct;

import static org.free13.rubik.coder.struct.JKeyword.WRAP;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public class JComment {

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

    public String toCode() {
        StringBuilder sb = new StringBuilder();
        if (comment == null) {
            return "";
        }
        String[] comments = comment.split(WRAP.simpleName());
        if (commentType == CommentType.BLOCK) {
            sb.append(JKeyword.COMMENT_JAVADOC_START.getKeyword());
            for (String comment : comments) {
                sb.append(JKeyword.COMMENT_BLOCK_LINE.getKeyword());
                sb.append(comment);
                sb.append(WRAP.getKeyword());
            }
            sb.append(JKeyword.COMMENT_JAVADOC_END.getKeyword());
        } else if (commentType == CommentType.JAVADOC) {
            sb.append(JKeyword.COMMENT_BLOCK_START.getKeyword());
            for (String comment : comments) {
                sb.append(JKeyword.COMMENT_BLOCK_LINE.getKeyword());
                sb.append(comment);
                sb.append(WRAP.getKeyword());
            }
            sb.append(JKeyword.COMMENT_BLOCK_END.getKeyword());
        } else if (commentType == CommentType.LINE) {
            for (String comment : comments) {
                sb.append(JKeyword.COMMENT_LINE.getKeyword());
                sb.append(comment);
                sb.append(WRAP.getKeyword());
            }
        }
        return sb.toString();
    }

    public static JComment of(String comment, CommentType commentType) {
        return JComment.builder().comment(comment).commentType(commentType).build();
    }

}
