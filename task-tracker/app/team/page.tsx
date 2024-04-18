'use client'

import { useEffect, useState } from "react";
import { title } from "@/components/primitives";
import { User } from "@/models/User";
import { UserService } from "@/services/UserService";
import { Avatar, AvatarGroup, AvatarIcon } from "@nextui-org/avatar";
import { Table, TableBody, TableCell, TableColumn, TableHeader, TableRow, getKeyValue } from "@nextui-org/react";

const columns = [
	{
		key: "firstName",
		label: "First Name",
	},
	{
		key: "lastName",
		label: "Last Name",
	},
	{
		key: "username",
		label: "Username",
	},
	{
		key: "email",
		label: "Email",
	},
  ];
  
export default function TeamPage() {

	const [users, setUsers] = useState<User[]>([]);

	useEffect(() => {
		UserService.getAllUsers().then((response) => {
			setUsers(response);
		});
	}, []);

	return (
		<div className="w-full">
			<h1 className={`${title()} py-5`}>Team members</h1>	
			<Table  aria-label="Example table with dynamic content">
				<TableHeader columns={columns}>
					{(column) => <TableColumn key={column.key}>{column.label}</TableColumn>}
				</TableHeader>
				<TableBody items={users}>
					{(item) => (
						<TableRow className="text-left" key={item.id}>
							{(columnKey) => <TableCell>{getKeyValue(item, columnKey)}</TableCell>}
						</TableRow>
					)}
				</TableBody>
			</Table>
		</div>
	);
}
