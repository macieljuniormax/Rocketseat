//
//  String+Ext.swift
//  02 - Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 16/06/25.
//

import Foundation

extension String {
    var localized: String {
        return NSLocalizedString(self, comment: "")
    }
}
